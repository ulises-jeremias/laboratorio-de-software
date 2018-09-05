package laboratorio;

public abstract class AbstractStrategist {
	public static WarStrategy getStrategyForRobot(CoDicRobot robot) {
		return new WarStrategy() {

			@Override
			public void handleMove() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handleAtack() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handleHit() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handleWall() {
				// TODO Auto-generated method stub
				
			}};
	}
}
