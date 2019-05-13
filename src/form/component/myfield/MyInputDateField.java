package form.component.myfield;

import java.text.SimpleDateFormat;


public class MyInputDateField extends MyInputTextField{
    
    private final SimpleDateFormat dateFormat;
    
    public MyInputDateField(String fieldName, String info, String pattern,boolean require) {
        super(fieldName, info, "",require);
        dateFormat = new SimpleDateFormat(pattern);
    }

    @Override
    public boolean validInput() {
        try{
            dateFormat.parse(txtField.getText().trim());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Object getValue() {
        try {
            return dateFormat.parse((String)super.getValue());
        } catch (Exception ex) {
            return null;
        }
    }
    
}
