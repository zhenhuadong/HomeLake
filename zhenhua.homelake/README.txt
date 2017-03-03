
1. How to create a maven project
mvn archetype:generate -DgroupId={project-packaging}
   -DartifactId={project-name}
   -DarchetypeArtifactId=maven-archetype-quickstart
   -DinteractiveMode=false
example:
mvn archetype:generate -DgroupId=com.zhenhua.homelake -DartifactId=zhenhua.homelake -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

2. update pom.xml
Junit:	
	<dependencies>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
	</dependencies>

build:
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.6.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>

3. import to eclipse

3.1 import directly
"File" -> "Import" -> "Maven" -> "Existing Maven project" -> "select zhenhua.homelake folder" -> "Finish".

3.2 maybe more fast
mvn eclipse:clean
mvn eclipse:eclipse
"File" -> "Import" -> "General" -> "Existing Projects into Workspace" -> "Finish".

  
   
   
 
 