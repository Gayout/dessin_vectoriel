package abstraction;

import implementation.Crayon;

public class Graffiti {
	private Chemin chemin;
	private Crayon crayon;
	
	public Graffiti(Chemin chemin, Crayon crayon) {
		super();
		this.chemin = chemin;
		this.crayon = crayon;
	}

	public Chemin getChemin() {
		return chemin;
	}

	public void setChemin(Chemin chemin) {
		this.chemin = chemin;
	}

	public Crayon getCrayon() {
		return crayon;
	}

	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}
}
