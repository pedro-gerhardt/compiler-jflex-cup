public class Declaration {
    public String name;
    public String objType;
    public String valueType;
   
    public Declaration(String name, String objType, String valueType){
        this.name = name;
        this.objType = objType;
        this.valueType = valueType;
    }

    @Override
    public String toString() {
        if (this.valueType != "")
            return this.name + " - " + this.objType + " - " + this.valueType;
        return this.name + " - " + this.objType;
    }
}
