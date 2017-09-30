# Dragons of Mugloar Simulator

This is simulator for https://www.dragonsofmugloar.com/ game api. 

# How to run simulator

  - Use **maven** and build the jar file or use the jar provided in lib folder.
  - Run **java -jar** on generated jar file. 
  - **Spring shell** will load.
  
# How to use simulator
  - Following command will show all available commands in a game:
    ```sh
    shell:>help
     ```
  - To generate default 10 fights, just write:
    ```sh
    shell:>start-fight
     ```
  - To generate 50 fights, just write:
    ```sh
    shell:>start-fight 50 
    ```
# Dependencies used
 *  **jersey** for calling game api.
 *  **lombok** for generating getters and setters for dto classes.
 *  **logback classic** for logging.
 *  **junit** and **mockito** for unit testing.
 *  **spring-shell** for running simulation commands.
 *  **spring-boot** for loading spring application.