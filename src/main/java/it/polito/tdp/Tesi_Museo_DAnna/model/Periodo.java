package it.polito.tdp.Tesi_Museo_DAnna.model;

public class Periodo {
		String periodo;

		public Periodo() {
			super();
			double prob=Math.random();
			if(prob<=0.0833) {
				this.periodo="13th-to 15th Century Italian";
			}
			else if(prob>0.0833 &&prob<=0.1666) {
				this.periodo="16th-Century Italian and Spanish";
			}
			else if(prob>0.1666 &&prob<=0.2499) {
				this.periodo="17th- and 18th-Century Italian, Spanish and French";
			}
			else if(prob>0.2499 &&prob<=0.3332) {
				this.periodo="15th-to 16th-Century Netherlandish and German";
			}
			else if(prob>0.3332 &&prob<=0.4164) {
				this.periodo="17th-Century Dutch and Flemish";
			}
			else if(prob>0.4164 &&prob<=0.4998) {
				this.periodo="18th- and 19th-Century Spanish";
			}
			else if(prob>0.4998 &&prob<=0.5831) {
				this.periodo="18th-and Early 19th-Century French";
			}
			else if(prob>0.5831 &&prob<=0.6664) {
				this.periodo="19th-Century French";
			}
			else if(prob>0.6664 &&prob<=0.7497) {
				this.periodo="British";
			}
			else if(prob>0.7497 &&prob<=0.833) {
				this.periodo="American";
			}
			else if(prob>0.833 &&prob<=0.9163) {
				this.periodo="Special Exhibitions";
			}
			else {
				this.periodo="Prints and Drawings";
			}
		}

		public Periodo(String periodo) {
			super();
			this.periodo = periodo;
		}

		public String getPeriodo() {
			return periodo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Periodo other = (Periodo) obj;
			if (periodo == null) {
				if (other.periodo != null)
					return false;
			} else if (!periodo.equals(other.periodo))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return periodo ;
		}
		
}
