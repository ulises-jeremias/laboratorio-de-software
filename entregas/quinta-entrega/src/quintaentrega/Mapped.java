package quintaentrega;

import java.io.Serializable;

@Archivo(name="Mapped.txt")
public class Mapped implements Serializable{
	private static final long serialVersionUID = 1L;

	@AlmacenarAtributo
	private String value = "myValue";

	@AlmacenarAtributo
	private int otherValue = 1;

	@AlmacenarAtributo
	private String nothing;

	@AlmacenarAtributo
	private Double valueFromConstructor;

	private String withoutAnnotation;

	private String withoutAnnotationButWithValue = "value";
	
	@AlmacenarAtributo
	private static String variableStatic = "static";
	
	private static String variableStaticWithoutAnnotation = "staticWithoutAnnotation =)";


	public Mapped(Double value) {
		this.valueFromConstructor = value;
	}
}
