package com.backbase;

//Jesus

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.LinkedList;

public class StripngPathChanger_Working {
  public String changeDirectoryString(String currentDirectory, String command) {
      StringBuilder result = null;
      try{
          if(Objects.isNull(command) || Objects.isNull(currentDirectory)){
              throw new IllegalStateException("Cd Command or currrentDirectory is not passed");
          }
          
          //System.out.println("********* The command is ******** "+command);

          if (command == null || !command.trim().startsWith("cd")) {
              throw new IllegalStateException("Command must start with 'cd '");
          }

      String pathCommand = command.substring(3).trim();        
      LinkedList<String> pathStack = new LinkedList<>();
      if (pathCommand.startsWith("/")) {
          pathCommand = pathCommand.substring(1);
      } else {
          String[] currentParts = currentDirectory.split("/");
          for (String part : currentParts) {
              if (!part.isEmpty()) {
                  pathStack.add(part);
              }
          }
      }

      String[] commandParts = pathCommand.split("/");
      for (String part : commandParts) {
          if (part.equals("..")) {
              if (!pathStack.isEmpty()) {
                  pathStack.removeLast();
              }
          } else if (!part.isEmpty() && !part.equals(".")) {
              pathStack.add(part);
          }
      }

      StringBuilder resultPath = new StringBuilder();
      for (String part : pathStack) {
          resultPath.append("/").append(part);
      }

      return resultPath.length() > 0 ? resultPath.toString() : "/";	
          

      } catch(Exception e){
          System.out.println("Exception occured while chaningin the Directory String");
          e.printStackTrace();
      }

      if (command == null || !command.trim().startsWith("cd")) {
              throw new IllegalStateException("Command must start with 'cd '");
          }



      return result.toString();
  }
}
