## Found hints
1. mvn validate to find properties values

```xml
             <plugin>
                 <groupId>org.apache.maven.plugins</groupId>
                 <artifactId>maven-antrun-plugin</artifactId>
                 <version>1.8</version>
                 <executions>
                     <execution>
                         <phase>validate</phase>
                         <goals>
                             <goal>run</goal>
                         </goals>
                         <configuration>
                             <tasks>
                                 <echoproperties />
                             </tasks>
                         </configuration>
                     </execution>
                 </executions>
             </plugin>
```