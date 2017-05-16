package cs3500.hw01.duration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/** Tests for the format method of {@link Duration}s. 
    Add your tests to this class to assure that your format 
    method works properly
*/
public abstract class AbstractDurationFormatTest {
  @Test
  public void formatExample1() {
    assertEquals("4 hours, 0 minutes, and 9 seconds",
                  hms(4, 0, 9)
                    .format("%h hours, %m minutes, and %s seconds"));
  }

  @Test
  public void formatExample2() {
    assertEquals("4:05:17",
                  hms(4, 5, 17).format("%h:%M:%S"));
  }

  // ADD MORE TESTS HERE
  // Your tests must only use hms(...) and sec(...) to construct new Durations
  // and must *not* directly say "new CompactDuration(...)" or
  // "new HmsDuration(...)"

  @Test
  public void formatExample3() {
    assertEquals("6 hours, 30 minutes, and 50 seconds",
            sec(23450)
                    .format("%h hours, %m minutes, and %s seconds"));
  }

  @Test
  public void formatExample4() {
    assertEquals("0:26:03",
            sec(1563).format("%h:%M:%S"));
  }

  @Test
  public void formatExample5() {
    assertEquals("%h 129",
            hms(0, 2, 9).format("%%h %t"));
  }

  @Test
  public void formatExample6() {
    assertEquals("%s 386",
            sec(386).format("%%s %t"));
  }

  @Test
  public void formatExample7() {
    assertEquals("129:03:02",
        hms(129, 3, 2).format("%H:%M:%S"));
  }

  @Test
  public void formatExample8() {
    assertEquals("00:9:0",
        hms(0, 9, 0).format("%H:%m:%s"));
  }

  @Test
  public void formatExample9() {
    assertEquals("332:56:01",
        sec(1198561).format("%H:%M:%S"));
  }

  @Test
  public void formatExample10() {
    assertEquals("02:43:20",
        sec(9800).format("%H:%m:%s"));
  }

  @Test
  public void formatExample11() {
    assertEquals("",
        sec(1198561).format(""));
  }

  @Test
  public void formatExample12() {
    assertEquals("hi",
        sec(9800).format("hi"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void formatExample13() {
    hms(4, 12, 23).format(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void formatExample14() {
    sec(1249).format(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void formatExample15() {
    hms(189, 3, 9).format("%r");
  }

  @Test(expected = IllegalArgumentException.class)
  public void formatExample16() {
    sec(123435).format("%r");
  }

  @Test(expected = IllegalArgumentException.class)
  public void formatExample17() {
    hms(12,34,35).format("%");
  }

  @Test(expected = IllegalArgumentException.class)
  public void formatExample18() {
    sec(123435).format("%");
  }
  

  /*
    Leave this section alone: It contains two abstract methods to
    create Durations, and concrete implementations of this testing class
    will supply particular implementations of Duration to be used within 
    your tests.
   */
  /**
   * Constructs an instance of the class under test representing the duration
   * given in hours, minutes, and seconds.
   *
   * @param hours the hours in the duration
   * @param minutes the minutes in the duration
   * @param seconds the seconds in the duration
   * @return an instance of the class under test
   */
  protected abstract Duration hms(int hours, int minutes, int seconds);

  /**
   * Constructs an instance of the class under test representing the duration
   * given in seconds.
   *
   * @param inSeconds the total seconds in the duration
   * @return an instance of the class under test
   */
  protected abstract Duration sec(long inSeconds);

  public static final class HmsDurationTest extends AbstractDurationFormatTest {
    @Override
    protected Duration hms(int hours, int minutes, int seconds) {
      return new HmsDuration(hours, minutes, seconds);
    }

    @Override
    protected Duration sec(long inSeconds) {
      return new HmsDuration(inSeconds);
    }
  }

  public static final class CompactDurationTest extends AbstractDurationFormatTest {
    @Override
    protected Duration hms(int hours, int minutes, int seconds) {
      return new CompactDuration(hours, minutes, seconds);
    }

    @Override
    protected Duration sec(long inSeconds) {
      return new CompactDuration(inSeconds);
    }
  }
}
