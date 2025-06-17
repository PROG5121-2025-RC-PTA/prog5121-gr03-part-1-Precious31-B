/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginandsignup;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * 
 */
public class LoginandSignUp {
     private static String userName;
    private static String password;
    private static String phoneNumber;
    private static String firstName;
    private static String lastName;
    
       public static void setFirstName(String fname) {
        firstName = fname;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setUserName(String username) {
        userName = username;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setPassword(String passw0rd) {
        password = passw0rd;
    }

    public static String getPassword() {
        return password;
        
        }

    public static void setLastname(String lname) {
        lastName = lname;
    }

    public static String getLastname() {
        return lastName;
        
    }
    
    public static void setCellNumber(String cellphonenumber){
        phoneNumber = cellphonenumber;
    }
    
    public static String getCellNumber(){
        return phoneNumber;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login(firstName, lastName);
        
        JOptionPane.showMessageDialog(null,"*Registration*");
        
        firstName =JOptionPane.showInputDialog(" Please enter your first name");
        lastName =JOptionPane.showInputDialog("Please enter your last tname");
        userName =JOptionPane.showInputDialog("Enter your user name.(Username has <5 and _)");
        password =JOptionPane.showInputDialog("Create a password.(Password must be >= 8 characters, have capital letter, a number and l speacial character.)");
        phoneNumber =JOptionPane.showInputDialog("Please enter phone number with country code");
        
        String regStatus = login.registerUser(userName, password, phoneNumber, firstName, lastName);
        JOptionPane.showMessageDialog(null, regStatus);
        
           if (regStatus.equals("Registration successful.")){
               JOptionPane.showMessageDialog(null,"*Login*" );
               String loginUser = JOptionPane.showInputDialog("Enter the username you created");
               String loginPass = JOptionPane.showInputDialog("Enter the password you created");
               
                String loginStatus = login.returnLoginStatus(loginUser, loginPass);
                JOptionPane.showMessageDialog(null, loginStatus);
                
                if(loginStatus.startsWith("Welcome")){
                    chatMenu chat = new chatMenu();
                    chat.run();  
    }
    
}
    
  }

}

 class Login{
      private String phoneNumber;
    private String firstName;
    private String lastName;
     
      // variables for checking login
    private String storedUsername;
    private String storedPassword;

    public Login(String fname, String lastname) {
        this.firstName = fname;
        this.lastName = lastname;
    }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        // Password must be at least 8 chars, 1 capital, 1 number, 1 special char
         boolean passwordOkay = false;
        boolean hasNumber = false;
        boolean hasCap = false;
        boolean hasChar = false;
        char current;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                current = password.charAt(i);
                
                
                if (Character.isUpperCase(current)){ 
                    hasCap = true;
                }
                if (Character.isDigit(current)){ 
                    hasNumber = true;
                }
                if (! (Character.isLetterOrDigit(current)) ){ 
                    hasChar = true;
                }
            }
            if (hasNumber && hasCap && hasChar){
                passwordOkay = true;
            }
            return passwordOkay;
    }
         return false;
    }

    public boolean checkCellPhoneNumber(String number) {
        // Reference regex from ChatGPT for checking international format and ≤ 10 digits
        String regex = "^\\+\\d{11,13}$"; // e.g. +27773456286
        return number.matches(regex);
    }

    public String registerUser(String username, String password, String cellNumber, String fName, String lName) {
        StringBuilder message = new StringBuilder();
        this.firstName = fName;
        this.lastName = lName;
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        message.append("Username successfully captured.\n");
        
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        message.append("Password successfully captured.\n");
        
        
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
            
        }
        message.append("Phone number successfully added.\n");
        

        this.phoneNumber = phoneNumber;
        this.storedUsername = username;
        this.storedPassword = password;

       
        JOptionPane.showMessageDialog(null, message.toString());
        return "Registration successful.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + this.firstName + " " + this.lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
            
        }
    }
    
}

class Message{
     private static int messageCount = 0;
    private String messageId;
    private int messageNumber;
    private String recipient;
    private String content;
    private String messageHash;

public Message(String recipient, String content, int messageNumber){
    
         this.messageId = generateMessageId();
        this.recipient = recipient;
        this.content = content;
        this.messageHash = createMessageHash(messageId, messageNumber, content);
        messageCount++;
}

private String generateMessageId() {
        Random rand = new Random();
        int id = 1000000000 + rand.nextInt(900000000);
        return String.valueOf(id);
}

public static boolean isValidMessageRecipient(String recipient){
    return recipient.matches("^\\+\\d{11,13}$");
}

public static boolean isValidMessageLength(String content){
    return content.length() <=250;
}

public String createMessageHash(String messageId1, int messageNumber1, String content1){
        String[] words = content.split("");
        String firstWord = words.length > 0 ? words[0] : "N/A";
        String lastWord = words.length > 1 ? words[words.length - 1] : "N/A";
        return (messageId.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
}
 
public String getMessageId(){ return messageId;}
public int getMessageNumber(){return messageNumber;}
public String getRecipient(){ return recipient;}
public String getContent(){ return content;}
public String getMessageHash(){ return messageHash;}

}

class chatMenu{
    private ArrayList<Message> sentMessages = new ArrayList<>();
    private ArrayList<Message> disregardedMessages = new ArrayList<>();
    private ArrayList<Message> storedMessages = new ArrayList<>();
    private int totalSent = 0;
    private int messageCount = 0;
    
    /**
     *
     */
   
    
    public void run() {
      JOptionPane.showMessageDialog(null, "Welcome to QuickChat");  
                  
            while (true){
             String option = JOptionPane.showInputDialog("""
                                                         Menu:
                                                         1.Send Message
                                                         2. View All Sent Messages
                                                         3. View Longest Message
                                                         4. Search Message by ID
                                                         5. Search Messages by Recipient
                                                         6. Delete Message by Hash
                                                         7. Show Message Report
                                                         8.Quit
                                                         """);
             if (option == null || option.equals("8")) {
                JOptionPane.showMessageDialog(null, "Exiting QuickChat. Goodbye!");
                break;
             }

            switch (option) {
                case "1":
                    sendMessage();
                    break;
                case "2":
                    showAllSentMessages();
                    break;
                case "3":
                    displayLongestMessage();
                    break;
                case "4":
                    searchByID();
                    break;
                case "5":
                    searchByRecipient();
                    break;
                case "6":
                    deleteByHash();
                    break;
                case "7":
                    displayReport();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        }
    }

    private void sendMessage() {
         int count = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));
        String recipient = JOptionPane.showInputDialog("Enter recipient cell (+27...):");
        if (!Message.isValidMessageRecipient(recipient)){
            JOptionPane.showMessageDialog(null, "Invalid recipient number.");
            return;
        }

        String content = JOptionPane.showInputDialog("Enter message (max 250 characters):");
        if (Message.isValidMessageLength(content)){
        } else {
            JOptionPane.showMessageDialog(null, "Message exceeds 250 characters. Disregarded.");
            disregardedMessages.add(new Message(recipient, content, ++messageCount));
            return;
        }

        String[] actions = {"Send Message", "Disregard Message", "Store Message"};
        int action = JOptionPane.showOptionDialog(null,
                "Choose an action:", "Message Action",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, actions, actions[0]);

        Message msg = new Message(recipient, content, ++messageCount);

        switch (action) {
            case 0: {
                sentMessages.add(msg);
                JOptionPane.showMessageDialog(null, "Message Sent!\nID: " + msg.getMessageId()
                        + "\nHash: " + msg.getMessageHash()
                        + "\nTo: " + msg.getRecipient()
                        + "\nMsg: " + msg.getContent());
            }
            case 1: disregardedMessages.add(msg);
            case 2: storedMessages.add(msg);
            default: JOptionPane.showMessageDialog(null, "No action taken.");
        }
    }

    private void showAllSentMessages() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages sent yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("Sent Messages:\n");
        for (Message m : sentMessages) {
            sb.append("ID: ").append(m.getMessageId())
              .append(" | Hash: ").append(m.getMessageHash())
              .append(" | To: ").append(m.getRecipient())
              .append(" | Msg: ").append(m.getContent()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void displayLongestMessage() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages to evaluate.");
            return;
        }

        Message longest = Collections.max(sentMessages, Comparator.comparingInt(m -> m.getContent().length()));
        JOptionPane.showMessageDialog(null, "Longest Message:\n" + longest.getContent());
    }

    private void searchByID() {
        String id = JOptionPane.showInputDialog("Enter Message ID:");
        for (Message m : sentMessages) {
            if (m.getMessageId().equals(id)) {
                JOptionPane.showMessageDialog(null, "Recipient: " + m.getRecipient()
                        + "\nMessage: " + m.getContent());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Message ID not found.");
    }

    private void searchByRecipient() {
        String rec = JOptionPane.showInputDialog("Enter recipient number:");
        StringBuilder found = new StringBuilder();
        for (Message m : sentMessages) {
            if (m.getRecipient().equals(rec)) {
                found.append("ID: ").append(m.getMessageId())
                     .append(" | Msg: ").append(m.getContent()).append("\n");
            }
        }

        if (found.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages found for that recipient.");
        } else {
            JOptionPane.showMessageDialog(null, found.toString());
        }
    }

    private void deleteByHash() {
        String hash = JOptionPane.showInputDialog("Enter message hash:");
        for (Iterator<Message> it = sentMessages.iterator(); it.hasNext(); ) {
            Message m = it.next();
            if (m.getMessageHash().equals(hash)) {
                it.remove();
                JOptionPane.showMessageDialog(null, "Message deleted.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Hash not found.");
    }

    private void displayReport() {
        StringBuilder report = new StringBuilder(" Message Report");
        for (Message m : sentMessages) {
            report.append("ID: ").append(m.getMessageId())
                  .append(" | Hash: ").append(m.getMessageHash())
                  .append(" | To: ").append(m.getRecipient())
                  .append(" | Msg: ").append(m.getContent()).append("\n");
        }
        report.append("Total Messages Sent: ").append(sentMessages.size());
        JOptionPane.showMessageDialog(null, report.toString());
    }
    @SuppressWarnings("unchecked")
    private void storeToJson(Message m){
        JSONObject json = new JSONObject();
        json.put("messageId", m.getMessageId());
        json.put("recipient", m.getRecipient());
        json.put("message", m.getContent());
        json.put("hash", m.getMessageHash());
       
      try (FileWriter fw = new FileWriter("store_messages.json",true)){
          fw.write(json.toJSONString() + "\n");
      }catch(Exception e){
          e.printStackTrace();
      }
    }
}


            