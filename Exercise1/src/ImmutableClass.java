import java.util.ArrayList;
import java.util.List;

final class ImmutableClass {
    private List<Integer> list;
    private final String stringField = "final string";
    private final SimpleClass simpleClassField = new SimpleClass(stringField);

    public ImmutableClass(List<Integer> list) {
        this.list = new ArrayList<>();
        for (Integer item : list) {
            this.list.add(item);
        }
    }

    public boolean strIsDigit(String stringField) {
        try {
            Integer.parseInt(stringField);
            System.out.println("true");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("false");
            return false;
        }
    }

    public List<Integer> getList() {
        return List.copyOf(list);
    }
}