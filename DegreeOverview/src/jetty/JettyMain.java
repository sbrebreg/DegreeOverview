package jetty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyMain {
	public static int BUFFER_SIZE = 10240;

	private static void createJarArchive(File[] tobeJared, JarOutputStream out) {
		try {
			byte buffer[] = new byte[BUFFER_SIZE];
			for (int i = 0; i < tobeJared.length; i++) {
				if (tobeJared[i] == null || !tobeJared[i].exists())
					continue; // Just in case...

				if (tobeJared[i].isDirectory()) {
					createJarArchive(tobeJared[i].listFiles(), out);
				} else {
					 // System.out.println("Adding " + tobeJared[i].getName());

					// Add archive entry
					JarEntry jarAdd = new JarEntry(
							tobeJared[i].getPath()
									.substring(
											tobeJared[i].getPath().indexOf(
													"classes") + 8));
					jarAdd.setTime(tobeJared[i].lastModified());
					out.putNextEntry(jarAdd);

					// Write file to archive
					FileInputStream in = new FileInputStream(tobeJared[i]);
					while (true) {
						int nRead = in.read(buffer, 0, buffer.length);
						if (nRead <= 0)
							break;
						out.write(buffer, 0, nRead);
					}
					in.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error: " + ex.getMessage());
		}
	}

	// If targetLocation does not exist, it will be created.
	public static void copyDirectory(File sourceLocation, File targetLocation)
			throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}

			String[] children = sourceLocation.list();
			for (int i = 0; i < children.length; i++) {
				copyDirectory(new File(sourceLocation, children[i]), new File(
						targetLocation, children[i]));
			}
		} else {
			InputStream in = new FileInputStream(sourceLocation);
			OutputStream out = new FileOutputStream(targetLocation);

			// Copy the bits from instream to outstream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("java.io.tmpdir",".");

		// Open archive file
		File targetLocation = new File("build/classes/easybeans-deploy");
		if (!targetLocation.exists()) {
			targetLocation.mkdir();
		}
		FileOutputStream stream = new FileOutputStream(new File(
				"build/classes/easybeans-deploy/ejb.jar"));
		JarOutputStream out = new JarOutputStream(stream);
		File classFiles = new File("build/classes");
		File jarSource[] = classFiles.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				if (name.equals("easybeans-deploy")
						|| name.equals("easybeans.xml") || name.equals("model"))
					return false;
				else
					return true;
			}

		});
		createJarArchive(jarSource, out);
		out.close();
		stream.close();

		// .class-Dateien nach WEB-INF/classes kopieren
		copyDirectory(new File("build/classes"), new File(
				"WebContent/WEB-INF/classes"));
		copyDirectory(new File("src/META-INF"), new File("WebContent/META-INF"));

		Server server = new Server(8080);
		Resource.setDefaultUseCaches(false);
		WebAppContext context = new WebAppContext();
		context.setBaseResource(new ResourceCollection(new String[] {
				"WebContent", "build/classes" }));
		context.setDescriptor("WEB-INF/web.xml");
		context.setContextPath("/");
		context.setParentLoaderPriority(true);
		// Enable Login Handling via users.properties
		context.getSecurityHandler().setLoginService(
				new HashLoginService("Login",
						"WebContent/WEB-INF/users.properties"));
		server.setHandler(context);

		server.start();
		server.join();
	}

}
