package br.com.guacom.java.nio.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest {

	public static void main(String[] args) {
		//Path � uma interface que define algumas opera��es.
		//A interface Path e a classe Paths que implementa Path, foi criada para substituir a classe File.

		Path p = Paths.get("C:\\Users\\elvis\\eclipse-workspace\\java-io\\arquivo.txt");
		Path p1 = Paths.get("C:\\Users\\elvis\\eclipse-workspace\\java-io", "arquivo.txt");
		Path p2 = Paths.get("C:", "Users\\elvis\\eclipse-workspace\\java-io", "arquivo.txt");
		Path p3 = Paths.get("C:", "Users", "elvis", "eclipse-workspace", "java-io", "arquivo.txt");

		System.out.println(p3.toAbsolutePath());
	
		//Converte um objeto do tipo Path para um objeto do tipo File
		File file = p.toFile();
		
		//Converte um objeto do tipo File em um objeto do tipo Path
		Path path = file.toPath();
	
		Path path2 = Paths.get("pasta\\subpasta\\subsubpasta");
		
		Path directory = Paths.get("pasta\\subpasta\\subsubpasta\\arquivo.txt");
		
		Path arquivo = Paths.get("pasta\\subpasta\\subsubpasta\\arquivo.txt");
		try {
//			Criando um diret�rio
//			if(Files.notExists(directory))
//				Files.createDirectory(directory);
	
//			Pegando apenas o diret�rio - getParent()
			if(Files.notExists(directory.getParent()))
				//Criando v�rios diret�rios
				Files.createDirectories(directory.getParent());
				//Se o arquivo ou diret�rio j� existirem o m�todo lan�a uma exce��o FilAlreadyExistsException
			if(Files.notExists(arquivo))
//				Criando um novo arquivo
				Files.createFile(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path source = Paths.get("C:\\Users\\elvis\\eclipse-workspace\\java-io\\directory2\\arquivo.txt");
		Path target = Paths.get(path2.toString() + "\\arquiCopiado.txt");
		try {
//			Copiando os dados do arquivo source para o arquivo target
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

//			Se o arquivo existir ele deleta, caso contr�rio n�o efetua.
			Files.deleteIfExists(target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
