package com.redpois0n;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Random;

public class Natives {
	
	private static String[] natives = new String[] {
		"jinput-dx8_64.dll", "jinput-dx8.dll", "jinput-raw_64.dll", "jinput-raw.dll", "jinput-wintab.dll", 
		"libjinput-linux.so", "libjinput-linux64.so", "libjinput-osx.jnilib",
		"liblwjgl.jnilib", "liblwjgl.so", "liblwjgl64.so",
		"libopenal.so", "libopenal64.so", "lwjgl.dll", "lwjgl64.dll", 
		"openal.dylib", "OpenAL32.dll", "OpenAL64.dll"
	};
	
	public static void writeNatives() throws Exception {
		writeNatives(new File(System.getProperty("java.io.tmpdir"), Integer.toString(new Random().nextInt())));
	}
	
	public static void writeNatives(File folder) throws Exception {
		
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		System.setProperty("java.library.path", folder.getAbsolutePath());
		
		for (String nativeLib : natives) {
			InputStream in = Main.class.getResourceAsStream("/natives/" + nativeLib);		
			FileOutputStream fos = new FileOutputStream(new File(folder, nativeLib));
			
			byte[] buffer = new byte[1024];
			int read = 0;
			
			while ((read = in.read(buffer)) != -1) {
				fos.write(buffer, 0, read);
			}
			
			fos.close();
			in.close();
		}
		
		folder.deleteOnExit();
	}

}
