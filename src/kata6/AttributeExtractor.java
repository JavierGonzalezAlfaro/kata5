package kata6;

public interface AttributeExtractor<Entity, Attribute> {
    
    public Attribute extract(Entity entity);
}
