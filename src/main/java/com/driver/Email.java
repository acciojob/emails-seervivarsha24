package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        boolean[] arr=new boolean[4];
        int count=0;
        if(oldPassword.equals(getPassword()) && newPassword.length()>=8){
            for(int i=0;i<newPassword.length();i++){
                int digit=newPassword.charAt(i);
                if(digit>64 && digit<91 && !arr[0]){
                    arr[0]=true;
                    count++;
                }
                else if(digit>96 && digit<123 && !arr[1]){
                    arr[1]=true;
                    count++;
                }
                else if(digit>47 && digit<58 && !arr[2]){
                    arr[2]=true;
                    count++;
                }
                else if(digit>32) {
                    arr[3]=true;
                    count++;
                }
            }
            if(count>=4){
                setPassword(newPassword);
                System.out.println("Password changed");
            }
            else
                System.out.println("Invalid Password");
        }
        else
            System.out.println("Password does not match");
    }
}
