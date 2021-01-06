package Practice;
public class ll2<E> {
	node<E> head=null;
	public void add(E data)
	{
		node<E> toAdd=new node<E>(data);
		if(free_h_kya())
		{
			head=toAdd;
			return;
		}
		node<E> temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=toAdd;
		return;
	}
	public void addfirst(E data)
	{
		node<E> toadd=new node<E>(data);
		if(free_h_kya())
		{
			head=toadd;
			return;
		}
		toadd.next=head;
		head=toadd;
		return;
	}
	public void addat(int pos,E data)
	{
		node<E> toadd=new node<E>(data);
		if(pos==1)
		{
			addfirst(data);
			return;
		}
		if (pos==2)
		{
			node<E> after=head.next;
			head.next=toadd;
			toadd.next=after;
			return;
		}
		node<E> temp=head;
		for(int i=1;i<pos;i++)
		{
			if (temp.next==null && i==pos-1)
			{
				add(data);
				return;
			}else if(temp.next==null && i!=pos-1)
			{
				System.out.println("Cannot add element at this position");
				return;
			}
			
			temp=temp.next;
		}
		node<E> after=temp.next;
		temp.next=toadd;
		toadd.next=after;
		return;
	}
	public void print()
	{
		if(free_h_kya())
		{
			System.out.println("The List is empty!!");
			return;
		}
		node<E> temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		return;
	}
	public boolean free_h_kya()
	{
		return(head==null);
	}
	public void GetLast()
	{
		if(free_h_kya())
		{
			System.out.println("nothing to show!!");
			return;
		}
		node<E> temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
	public void remove()
	{
		if(free_h_kya())
		{
			System.out.println("nothing to show!!");
			return;
		}
		if(head.next==null)
		{
			node<E>toremove=head;
			head=null;
			System.out.println("Data removed is:"+toremove);
			return;
		}
		node<E> temp=head;
		while(temp.next.next!=null)
		{
			temp=temp.next;
		}
		node<E> toremove=temp;
		temp.next=null;
		System.out.println("Data removed is:"+temp.data);
	}
	public void removefirst()
	{
		node<E> toremove=head;
		if(head.next==null) 
		{
			head=null;
			System.out.println("Data Removed is: "+toremove.data);
			return;
		}
		head=head.next;
		System.out.println("Data Removed is: "+toremove.data);
	}
	public int number_of_elements()
	{
		int n=1;
		node<E> count=head;
		while(count.next!=null)
		{
			count=count.next;
			n++;
		}
		return n; 
	}
	public void removefrom(int pos)
	{
		if(free_h_kya())
		{
			System.out.println("Nothing to remove");
			return ;
		}
		if(number_of_elements()==pos)
		{
			remove();
			return;
		}
		if(number_of_elements()<pos)
		{
			System.out.println("Please Enter Valid Position");
			return;
		}
		if (pos==1)
		{
			removefirst();
			return ;
		}
		node<E> toremove=head;
		for(int i=1;i<pos-1;i++)
		{
			toremove=toremove.next;
		}
		node<E> temp=toremove.next;
		toremove.next=toremove.next.next;
		System.out.println("Data removed is: "+temp.data);
	}
	static class node<E>
	{
		E data;
		node next;
		public node(E data)
		{
			this.data=data;
			next=null;
		}
	}
}
   