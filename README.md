### TextFileClient

#### Overview

The `TextFileClient` is a Java application developed for the Advanced Object-Oriented Programming course. This client connects to a server and sends a text file to it. The server then processes the file and sends back information about the file to the client.

#### Usage

1. Compile the `TextFileClient` class.

   ```bash
   javac TextFileClient.java
   ```

2. Run the compiled client.

   ```bash
   java TextFileClient
   ```

3. Enter the name of the file you want to send when prompted.

#### Functionality

- Connects to a server using a socket on localhost and port 1234.
- Accepts user input for the file name.
- Sends the content of the specified file to the server.
- Receives and displays the results from the server.

#### Note

- Make sure that the corresponding `TextFileServer` is running before executing the client.

---

### TextFileServer

#### Overview

The `TextFileServer` is a Java server application developed for the Advanced Object-Oriented Programming course. It listens on port 1234 for incoming connections from clients. Upon connection, it receives a text file, processes it, and sends relevant information back to the client.

#### Usage

1. Compile the `TextFileServer` class.

   ```bash
   javac TextFileServer.java
   ```

2. Run the compiled server.

   ```bash
   java TextFileServer
   ```

#### Functionality

- Listens on port 1234 for incoming client connections.
- Accepts a file from the client, saves it as "received.txt," and processes it.
- Calculates the number of words in the file.
- Determines the longest word in the file.
- Sends back information about the file to the client.

#### Note

- Ensure that the corresponding `TextFileClient` is executed after starting the server.

---

Feel free to customize these READMEs based on additional details or specific instructions relevant to your project or course requirements.
