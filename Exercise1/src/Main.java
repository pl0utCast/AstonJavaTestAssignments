void main() {
    List<Integer> SimpleList = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
    ImmutableClass iClass = new ImmutableClass(SimpleList);
    iClass.StrIsDigit("132352");
    System.out.println("work after exception handled(if there any)");
    iClass.EditInnerClassState("New Value");
    System.out.println(iClass.getList());
}

protected final class ImmutableClass{
    private ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    private final String StringField = "final string";
    private final SimpleClass SimpleClassField = new SimpleClass(StringField);

    public ImmutableClass(List<Integer> list){
        this.list = new ArrayList<>();
        for (Integer item: list){
            this.list.add(item);
        }
    }

    public boolean StrIsDigit(String StringField){
        try
        {
            Integer.parseInt(StringField);
            System.out.println("true");
            return true;
        }
        catch (NumberFormatException e)
        {
            System.out.println("false");
            return false;
        }
    }
    private void EditInnerClassState(String SimpleField){
        //Доступ к private-члену класса возможен, потому что оба класса являются вложенными для public final class Main,
        //заданного неявно
        SimpleClassField.SimpleField = SimpleField;
        System.out.println("New value is: " + SimpleField);
    }

    //Возврат неизменяемой копии
    public List<Integer> getList() {
        return Collections.unmodifiableList(list);
    }
}

public class SimpleClass{
    private String SimpleField;
    public SimpleClass(){

    }

    public SimpleClass(String SimpleField){
        this.SimpleField = SimpleField;
    }

    public String getSimpleField(){
        return SimpleField;
    }

    public void setSimpleField(String SimpleField){
        this.SimpleField = SimpleField;
    }
}