package MEP;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import java.awt.*;
public class SentryBot extends Robot {
	int turnDirection = 1; // Clockwise or counterclockwise
	public void run() {
		// Set colors
		setBodyColor(Color.red);
		setGunColor(Color.gray);
		setRadarColor(Color.darkGray);

		while (true) {
			turnRadarRight(45 * turnDirection);
		}//END WHILE
	}//END run

	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getEnergy() > 200) {
			return;
		}//END IF
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}//END IF
		turnRight(e.getBearing());
		smartFire();
		ahead(e.getDistance());
		scan(); // Might want to move ahead again!
	}//END onScannedRobot
	
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}//END IF
		turnRight(e.getBearing());
		smartFire();
		ahead(40); // Ram him again!
	}//END OnHitRobot
	
	public int smartFire() {
		if (getGunHeat() == 0) {
			fire(3);
			return 1;
		} else {
			return 0;
		}//END IF ELSE
	}//END smartFire
}