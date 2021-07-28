package com.example.demo.load_class;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class MyClassLoader extends  ClassLoader {

    @Override
    @SneakyThrows
    public Class<?> findClass(String className) {
        //HashMap<String, byte[]> classNamesFromJarFile = getClassNamesFromJarFile(className);
        String fileName = "target/classes/" + className.replace('.', File.separatorChar) + ".class";
        byte[] byteCode = Files.newInputStream(Path.of(fileName)).readAllBytes();
        return defineClass(className, byteCode,0, byteCode.length);

    }

    /*public static HashMap<String,byte[]> getClassNamesFromJarFile(String givenFile) throws IOException {
        HashMap<String,byte[]> classNames = new HashMap<String, byte[]>();
        ZipInputStream zip = new ZipInputStream(new FileInputStream(givenFile));
        for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
            if (!entry.isDirectory() && entry.getName().endsWith(".class")) {

                // This ZipEntry represents a class. Now, what class does it represent?
                String className = entry.getName().replace('/', '.'); // including ".class"
                classNames.put(className.substring(0, className.length() - ".class".length()),entry.getExtra());
            }
        }
        return classNames;
    }*/
}




