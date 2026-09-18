/*
    What is I/O ?   --> A java application constantly needs to communicate something outside the
                        program.  Ex: Read the file, Write the file etc..
    What is stream? --> It is a flow of data not that stream which We learn in Stream API
                        In stream api we learn list.stream()...
                But in I/O stream we'll learn InputStream,OutputStream, Reader,Writer...

Two directions of I/O
    Data comes into the program --- input
    Data goes out of the program --- output
    

                    Four fundamentales I/O families
    Java I/O----> Bytes    --- Input Stream, Output Stream
                  Characters-- Reader , Writer


                    Byte Stream vs Character Stream
    Byte Streams--> Used for raw data like images, audio, video, pdf,binary files, zip
    Character Streams--> Used primarily for texts like .txt file, .csv file, 
                        .json file, .xml file, source code , configuration file
    
    Input Stream----
    It is abstract class representing an input stream of bytes
        Some important subclasses
            FileInputStream
            ByteArrayInputStream
            BufferedInputStream
            ObjectInputStream
 */

import java.io.IOException;
import java.io.FileInputStream;

public class basics {
        public static void main(String args[]) throws IOException{
            FileInputStream in= new FileInputStream("data.txt");
            int data;
            while((data=in.read())!=-1){   
                System.out.print((char)data);
            }
            in.close();
        }
        /*  in this program, there is a conditions where the line is 
            data=in.read()     as read() reads one byte
                It returns 0-255  -> actual byte       -1 for end of the stream 
                that's why the condition is data=in.read() means keep reading until there 
                is no more data

    Q. Why does read() return int instead of byte?
    --> Because -1 needed to represent End Of File.  A byte has 256 possible values. Java needs
        a separate value of EOF. So read() returns an int.  0-255== valid type but -1= EOF is an int
        that is the reason.
Memory Perspective...... Suppose: data.txt="ABC" when java executes in.read() then OS/file system
                                    provides data to java
            Conceptually--    Disk--A-->Java Application--int data---> stack
                                then (char)data that converts numeric value to character
                                'A'--> 65
                                'B'--> 66
                                'C'--> 67   So, System.out.println((char)65);
                Q. Why casting to char?  Because: read() returns an int
                 */
    
}