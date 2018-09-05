package com.ecvlearning.javaee.designPattern.state;

public class Checkbox {
    private boolean checked = false;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void click(){
        if(this.checked){
            System.out.println("Uncheck!");
            this.checked = false;
        }else{
            System.out.println("Check!");
            this.checked = true;
        }
    }
}
