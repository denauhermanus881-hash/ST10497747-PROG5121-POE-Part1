public class Login {

    private String userVal;
    private String passVal;
    private String fName;
    private String lName;
    private String cellNum;

    public Login() {
    }

    public Login(String userVal, String passVal, String fName, String lName, String cellNum) {
        this.userVal = userVal;
        this.passVal = passVal;
        this.fName = fName;
        this.lName = lName;
        this.cellNum = cellNum;
    }

    public String getUsername() {
        return userVal;
    }

    public void setUsername(String userVal) {
        this.userVal = userVal;
    }

    public String getPassword() {
        return passVal;
    }

    public void setPassword(String passVal) {
        this.passVal = passVal;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    public String getCellPhoneNumber() {
        return cellNum;
    }

    public void setCellPhoneNumber(String cellNum) {
        this.cellNum = cellNum;
    }

    public boolean checkUserName() {
        if (userVal == null) return false;
        return userVal.contains("_") && userVal.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        if (passVal == null || passVal.length() < 8) {
            return false;
        }

        boolean upperFound = false;
        boolean numFound = false;
        boolean specFound = false;

        for (int i = 0; i < passVal.length(); i++) {
            char c = passVal.charAt(i);
            if (Character.isUpperCase(c)) {
                upperFound = true;
            } else if (Character.isDigit(c)) {
                numFound = true;
            } else if (!Character.isLetterOrDigit(c)) {
                specFound = true;
            }
        }

        return upperFound && numFound && specFound;
    }

    public boolean checkCellPhoneNumber() {
        if (cellNum == null) return false;
        return cellNum.matches("^\\+27\\d{8,10}$");
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        return "The two above conditions have been met, and the user has been registered successfully.";
    }

    public boolean loginUser(String inputUser, String inputPass) {
        if (inputUser == null || inputPass == null) return false;
        return inputUser.equals(this.userVal) && inputPass.equals(this.passVal);
    }

    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + fName + ", " + lName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}