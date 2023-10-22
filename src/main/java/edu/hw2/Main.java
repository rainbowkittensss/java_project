package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
   public static final Logger LOGGER = LogManager.getLogger();
   public static Task4.CallingInfo forTestOfTask4(){
       return Task4.getCallingInfo();
   }
}
