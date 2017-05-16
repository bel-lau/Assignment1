package cs3500.hw01.publication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WebpageTest {
  Publication northeastern = new Webpage("Northeastern University", "northeastern.edu",
      "May 9, 2017");

  @Test
  public void testCiteApa() {
    assertEquals("Northeastern University. Retrieved May 9, 2017, from northeastern.edu.",
        northeastern.citeApa());
  }

  @Test
  public void testCiteMla() {
    assertEquals("\"Northeastern University.\" Web. May 9, 2017 <northeastern.edu>.",
         northeastern.citeMla());
  }
}