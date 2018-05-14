# StarterBot
A StarterBot for the Programming Contest of CognAC &amp; Thalia

## Instructions
1. Clone the repository and use your prefered IDE to open the project.
1. Create a new class and have it implement the Bot interface.
1. Implement all methods. Make sure to return the right Coordinates.
1. Adjust the main so that it uses your bot.

## Testing
You can test your bot by using the ClientRunner and the Server. Additionally, you can simply run and use the console to interact with it. There is some simple error handling which might help you to find bugs.

## Running it
To actually run your bot you will have to do the following.
1. Build the jar. In most IDEs you can do that by right clicking the project and selecting build from the context menu.
1. Place the jar in the framework directory, i.e. where the Server and the ClientRunner lies.
1. Edit the config so it looks similar to this:
```
# BOT RUNNING COMMAND:
java -jar ./<YourBot>.jar
```
