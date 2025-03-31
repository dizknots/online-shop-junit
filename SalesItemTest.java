import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    private SalesItem item;
    private Comment comment1, comment2;
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        item = new SalesItem("Phone", 299);
        comment1 = new Comment("user1", "Good product", 5);
        comment2 = new Comment("user2", "Average", 3);
        
        item.addComment("user1", "Good product", 5);
        item.addComment("user2", "Average", 3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }

    @Test
    public void addComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain Surgery for Dummies.", 9899);
        assertEquals(true, salesIte1.addComment("Fred", "Great - I perform brain surgery every week now!", 4));
    }
    
    public void testAddDuplicateComment() {
        SalesItem item = new SalesItem("Phone", 299);
    
        assertTrue(item.addComment("Bob", "Nice", 5));
        assertFalse(item.addComment("Bob", "Great", 4));
    }
    
    public void testBoundaryRatingRange()
    {
        Comment validComment = new Comment("Bob", "Nice!", 3);
        assertTrue(validComment.getRating() >= 1 && validComment.getRating() <= 5);
        
        Comment lowRating = new Comment("Joe", "Too low", 0);
        Comment highRating = new Comment("Brody", "Too high", 6);
        
        assertFalse(lowRating.getRating() >= 1 && lowRating.getRating() <= 5);
        assertFalse(highRating.getRating() >= 1 && highRating.getRating() <= 5);
    }
    
    public void testCommentDetails() {
        Comment comment = new Comment("Bob", "Great product", 4);
    
        assertEquals("Bob", comment.getAuthor());
        assertEquals(4, comment.getRating());
        assertEquals("Great product", comment.getText());
    }
    
     public void testFindMostHelpfulComment() {
        Comment mostHelpful = item.findMostHelpfulComment();
        assertNotNull(mostHelpful);
        assertEquals("Good product", mostHelpful.getText());
    }
    
    public void testAddCommentToSaleItem() {
    SalesItem item = new SalesItem("Laptop", 499);
    Comment comment = new Comment("user1", "Amazing performance", 5);
    
    item.addComment("user1", "Amazing performance", 5);
    assertNotNull(item.findMostHelpfulComment());
    }
    
}





