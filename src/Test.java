
import B.P.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test {

	public static void main(String[] args)
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx= session.beginTransaction();
		for(int i=0;i<1000;i++)
		{
			Book b = new Book();
                        int n = i + 1 ;
			b.setTitle("book_title" + n);
			b.setAuthor("book_author");
                        
			session.save(b); // still on session
			if(i%100==0){
			session.flush();
                        /// insert to DB before commit transaction
			session.clear(); /// session clean
			}
		}
		
		
		tx.commit();
		session.close();
		
			
	}

}
