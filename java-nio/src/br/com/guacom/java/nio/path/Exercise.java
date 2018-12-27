package br.com.guacom.java.nio.path;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise {
	
	public static void main(String[] args) {
		/*
		File file = Paths.get("temp\\arquivoExercicio.txt").toFile();
		try {
			if(Files.notExists(file.toPath()))
				Files.createFile(file.toPath());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path target = Paths.get("temp\\arquivo.txt");
		
		System.out.println(file.renameTo(target.toFile()));
		
		File directory = Paths.get("temp").toFile();
		
		try {
			if(Files.notExists(directory.toPath()))
				Files.createDirectory(directory.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
//		searchFiles();
//		write();
//		directory.mkdir();
		read();
	}
	
	public static void searchFiles() {
		File archive = Paths.get("C:\\").toFile();
		List<String> files = Arrays.asList(archive.list());
		
		files.forEach(action -> {
			System.out.println(action);
		});
	}
	
	public static void read() {
		Path path = Paths.get("archive.txt");
		StringBuffer buffer = new StringBuffer();
		String s = null;
		try(RandomAccessFile acessFile = new RandomAccessFile(path.toFile(), "r")) {
			if(Files.notExists(path))
				Files.createFile(path);
				
				while((s = acessFile.readLine()) != null) {
					buffer.append(s);
					buffer.append(System.lineSeparator());
				}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String builded = buffer.toString();
		System.out.println(builded);
	
	}
	
	public static void write() {
		File file = Paths.get("archive.txt").toFile();
		PrintStream writer;
		try {
			if(Files.notExists(file.toPath()))
				Files.createFile(file.toPath());
			
			if(Files.exists(file.toPath())) {
				writer = new PrintStream(Files.newOutputStream(file.toPath()));
				writer.println("#Lista de exercícios de Java I/O - para disciplina SD-II - 11/03/2013\r\n" + 
						"\r\n" + 
						"Desenvolva scripts de código em um programa no método main para:\r\n" + 
						"criar um arquivo no sistema operacional\r\n" + 
						"alterar o nome do arquivo criado\r\n" + 
						"criar um diretório comm o nome 'temp'\r\n" + 
						"criar vários arquivos dentro deste diretório recem criado\r\n" + 
						"mostre no console cada um dos arquivos contidos na pasta c:/\r\n" + 
						"crie um arquivo, passe todo o conteúdo desta lista de exercícios para ele usuando FileWriter\r\n" + 
						"mostre no console este arquivo recém criado usando FileReader\r\n" + 
						"mostre agora com o RandomAccesFile\r\n" + 
						"como você faria para mostrar o conteúdo do arquivo com a classe Scanner\r\n" + 
						"agora que você já leu com estes mecanismos, delete o arquivo (usano a API)\r\n" + 
						"copie o conteúdo de uma imagem que está na sua pasta em Documents and settings/images para a pasta raiz do computado\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
