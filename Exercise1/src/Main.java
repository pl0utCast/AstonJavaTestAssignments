void main() {
    List<Integer> simpleList = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
    ImmutableClass iClass = new ImmutableClass(simpleList);
    iClass.strIsDigit("132352");
    System.out.println("work after exception handled(if there any)");
    System.out.println(iClass.getList());
}