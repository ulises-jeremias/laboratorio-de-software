package cuartaentrega;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestGuitarra {
  private Guitarra guitarra;
	
  @BeforeEach
  void setUp() throws Exception {
	  guitarra = new Guitarra();
  }

  @Test
  void testQueEs() {
	  assertEquals("No funciona", "Guitarra", guitarra.queEs());
  }
  
  @Test
  void testSonido() {
	  String expected = "Sonido de guitarra: SOL G y dura: 10";
	  guitarra.hacerSonar(Notas.SOL, 10);
	  assertEquals("Error al hacer sonar", "Sonido de guitarra: " + Notas.SOL.getName() + " " + Notas.SOL.getNote() + " y dura: " + new Integer(10).toString(), expected);
  }
  
  @Test
  void testAfinacion() {
	  String expected = "Afinando en frecuencia: 444hz - tambien llamado... Camera tunning";
	  guitarra.afinar(FrecuenciaDeLA.CAMERA);
	  assertEquals("Error al afinar", "Afinando en frecuencia: " + FrecuenciaDeLA.CAMERA.getFrecuency() + "hz - tambien llamado... " + FrecuenciaDeLA.CAMERA.getName(), expected);
  }
}

