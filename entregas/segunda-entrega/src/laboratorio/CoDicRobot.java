package laboratorio;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class CoDicRobot extends JuniorRobot
{

	private WarStrategy warStrategy;
	
	@Override	
	public void run() {

		setColors(orange, blue, white, yellow, black);


		while(true) {
			warStrategy = WarStrategist.getStrategyForRobot(this);
			warStrategy.handleMove();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		warStrategy.handleAtack();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		warStrategy.handleHit();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		warStrategy.handleWall();
	}	
}