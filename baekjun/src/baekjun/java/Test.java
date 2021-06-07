package baekjun.java;


class	Point	{
	int	x;
	int	y;
	void	assign(int	x,	int	y)	{
					x	=	this.x;
					this.y	=	y;
	}
	public	String	toString()	{
					return	"Point("	+	x	+	",	"	+	y	+	")";
	}
}
public	class	Test	{
	public	static	void	main(String[]	args)	{
					Point	p1	=	new	Point();
					p1.x	=	10;
					p1.y	=	20;
					Point	p2	=	new	Point();
					p2.assign(p1.x,	p1.y);
					System.out.println(p1.toString()	+	";"	+	p2.toString());
	}
}