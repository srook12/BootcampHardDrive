
// int a = 90;b = 45,c = 46,d = 95,e = 78,f = 91,g = 89,h = 35,i = 83,j = 98,k = 36,l = 27,m = 18,n = 67,o = 64,
// p = 67,q = 20,r = 29,s = 41,t = 71,u = 17,v = 23,w = 92,x = 3,y = 81,z = 48,
public class ProgramWithBugs {

	public static void main(String[] args) {
		int a = 90, b = 45,c = 46,d = 95,e = 78,f = 91,
				g = 89,h = 35,i = 83,j = 98,k = 36,l = 27,
				m = 1,n = 67,o = 64,p = 67,q = 20,r = 29,
				s = 41,t = 71,u = 17,v = 23,w = 92,x = 3,
				y = 81,z = 48;
		int answer = (g+v)*n/t-(o/2+7)-(k*f*w)*q/(--x*m-2)*r+j*(b-o)/e;
		System.out.println(answer);
	}
}
