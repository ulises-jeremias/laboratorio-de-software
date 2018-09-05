package laboratorio;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class CoDicRobot extends JuniorRobot
{
	private WarStrategy strategy;
	
	@Override	
	public void run() {

		setColors(orange, blue, white, yellow, black);


		while(true) {
			strategy = WarStrategist.getStrategyForRobot(this);
			strategy.handleMove();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		strategy.handleAtack();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		strategy.handleHit();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		strategy.handleWall();
	}	
}