package laboratorio;

public class PeaceStrategist extends AbstractStrategist {
	private static PeaceStrategist instance = new PeaceStrategist();
	
	private PeaceStrategist() {}
	
	public PeaceStrategist getStrategist() {
		return instance;
	}
	
	private WarStrategy getNormalStrategyForRobot(CoDicRobot robot) {
		return new WarStrategy() {
			
			private int time = 0;
			private int positions[] = { 79, -51, 75, 141, 125, -129, 100, -141 };

			@Override
			public void handleMove() {
				if (time == 8) { 
					time = 0;
				}
				
				if (positions[time + 1] > 0) {
					robot.turnRight(positions[time + 1]);
				} else {
					robot.turnLeft(-positions[time + 1]);
				}
				
				robot.ahead(positions[time]);
				time += 2;
			}

			@Override
			public void handleAtack() {
				robot.turnGunRight(10);
			}

			@Override
			public void handleHit() {
				robot.ahead(75);
				robot.turnLeft(15);
				robot.back(85);
				robot.turnRight(20);
			}

			@Override
			public void handleWall() {
				robot.ahead(75);
				robot.turnLeft(15);
				robot.back(85);
				robot.turnRight(20);
			}
			
		};
	}
	
	private WarStrategy getWarningStrategyForRobot(CoDicRobot robot) {
		return new WarStrategy() {

			private int time = 0;
			private int positions[] = { 79, -51, 75, 141, 125, -129, 100, -141 };

			@Override
			public void handleMove() {
				if (time == 8) { 
					time = 0;
				}
				
				if (positions[time + 1] > 0) {
					robot.turnRight(positions[time + 1]);
				} else {
					robot.turnLeft(-positions[time + 1]);
				}
				
				robot.ahead(positions[time]);
				time += 2;
			}

			@Override
			public void handleAtack() {		
				robot.turnGunTo(robot.scannedAngle);
				robot.fire(0.5);
			}

			@Override
			public void handleHit() {
				robot.ahead(65);
				robot.turnLeft(10);
				robot.back(75);
				robot.turnRight(15);
				robot.turnGunTo(robot.hitByBulletAngle);
				robot.fire(1);
			}

			@Override
			public void handleWall() {
				robot.ahead(75);
				robot.turnLeft(15);
				robot.back(85);
				robot.turnRight(20);
			}
			
		};
	}
	
	public static WarStrategy getStrategyForRobot(CoDicRobot robot) {
		if (robot.energy <= 60) {
			return instance.getWarningStrategyForRobot(robot);
		}
		
		return instance.getNormalStrategyForRobot(robot);
	}
}
