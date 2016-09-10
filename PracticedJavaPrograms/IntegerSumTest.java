import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class IntegerSumTest {
	@Test
	public void testSum(){
	long l= 0;
	for(int i= Integer.MIN_VALUE;i<=Integer.MAX_VALUE;i++)
	{
		l+=i;
	}
	assertTrue(l==0);
	}
}  