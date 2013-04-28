package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lib.Clock;
import _001._001;
import _002._002;
import _003._003;
import _004._004;
import _005._005;
import _006._006;
import _007._007;
import _008._008;
import _009._009;
import _010._010;
import _011._011;
import _012._012;
import _013._013;
import _014._014;
import _015._015;
import _016._016;
import _017._017;
import _018._018;
import _019._019;
import _020._020;
import _021._021;
import _022._022;
import _023._023;
import _024._024;
import _025._025;
import _026._026;
import _027._027;
import _028._028;
import _029._029;
import _030._030;
import _031._031;
import _032._032;
import _033._033;
import _034._034;
import _035._035;
import _036._036;
import _037._037;
import _038._038;
import _039._039;
import _040._040;
import _041._041;
import _042._042;
import _043._043;
import _044._044;
import _045._045;
import _046._046;
import _047._047;
import _048._048;
import _049._049;
import _050._050;
import _053._053;
import _057._057;
import _063._063;
import _067._067;
import _071._071;
import _072._072;
import _073._073;

public class Runner {

	public static void main(String[] args) {
		Runner r = new Runner();
		r.run();
	}
	
	public void run() {
		
		Clock clock = Clock.getInstance();
		Map<Integer, Class<?>> problems = Runner.getProblems();
		List<Integer> keys = new LinkedList<Integer>(problems.keySet());
		Collections.sort(keys);
		
		for(Integer key : keys) {
			try {
				Class<?> p = problems.get(key);
			    System.out.println("Problem #" + key);
			    clock.start();
			    System.out.print("Answer: ");
			    p.newInstance();
				System.out.println("Time: " + clock.elapsedMillis() / 1000.0 + "s");
				clock.reset();
				System.out.println();
			} catch (Exception e) {
				// Pokemon, gotta catch'em all!
			} 
		}
	}
	
	public static Map<Integer, Class<?>> getProblems() {
		Map<Integer, Class<?>> p = new HashMap<Integer, Class<?>>();
		p.put(1, _001.class);
		p.put(2, _002.class);
		p.put(3, _003.class);
		p.put(4, _004.class);
		p.put(5, _005.class);
		p.put(6, _006.class);
		p.put(7, _007.class);
		p.put(8, _008.class);
		p.put(9, _009.class);
		p.put(10, _010.class);
		p.put(11, _011.class);
		p.put(12, _012.class);
		p.put(13, _013.class);
		p.put(14, _014.class);
		p.put(15, _015.class);
		p.put(16, _016.class);
		p.put(17, _017.class);
		p.put(18, _018.class);
		p.put(19, _019.class);
		p.put(20, _020.class);
		p.put(21, _021.class);
		p.put(22, _022.class);
		p.put(23, _023.class);
		p.put(24, _024.class);
		p.put(25, _025.class);
		p.put(26, _026.class);
		p.put(27, _027.class);
		p.put(28, _028.class);
		p.put(29, _029.class);
		p.put(30, _030.class);
		p.put(31, _031.class);
		p.put(32, _032.class);
		p.put(33, _033.class);
		p.put(34, _034.class);
		p.put(35, _035.class);
		p.put(36, _036.class);
		p.put(37, _037.class);
		p.put(38, _038.class);
		p.put(39, _039.class);
		p.put(40, _040.class);
		p.put(41, _041.class);
		p.put(42, _042.class);
		p.put(43, _043.class);
		p.put(44, _044.class);
		p.put(45, _045.class);
		p.put(46, _046.class);
		p.put(47, _047.class);
		p.put(48, _048.class);
		p.put(49, _049.class);
		p.put(50, _050.class);
		p.put(53, _053.class);
		p.put(57, _057.class);
		p.put(63, _063.class);	
		p.put(67, _067.class);
		p.put(71, _071.class);
		p.put(72, _072.class);
		p.put(73, _073.class);
		return p;
	}

}
