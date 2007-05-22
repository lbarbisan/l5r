package fr.lb.l5r.business.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.Range;

import fr.lb.l5r.business.entities.interfaces.IEntity;

/**
 * Cette classe représente un personnage joueur, elle stocke les informations du
 * joueur mais ne contient en aucun cas toutes l'intelligence.
 *  
 * @author lbarbisan
 */
@Entity
public class PersonnageJoueur extends fr.lb.l5r.business.entities.Entity implements Serializable, IEntity {

	
	@Transient private static final long serialVersionUID = 3660945876033804055L;
	
	//Identité
	private String name;
	private String clan;
	private String school;
	private String rank;

	//Réputation
	private long insight;
	
	//Anneaux de terre
	private long earthRing;
	private long stamina = 2;		//CDC:1
	private long willpower = 2;		//CDC:1

	//Anneaux d'eau	
	private long waterRing;
	private long strength = 2; 		//CDC:1
	private long perception = 2;	//CDC:1

	//Anneaux de feu
	private long fireRing;
	private long agility = 2;		//CDC:1
	private long intelligence = 2;	//CDC:1

	//Anneaux d'air	
	private long airRing;
	private long reflexes = 2;		//CDC:1
	private long awareness = 2;		//CDC:1

	//Anneaux de vide
	private long voidRing = 2;		//CDC:1
	private long voidRingPointsSpent;
	
	//structure avancée
	private long glory;
	private long honor;
	private long status;
	private long shadowLandsTaint;
	
	//ND pour être touché
	private long TN;
	
	//Initiative
	private long initiative;
	
	//Background
	//TODO: Permettre d'influencer les caractéristiques avec le background 
	private String background;		//CDC:4
	
	//Compétences
	//private Collection<Skill> skills;
	
	//Techniques
	//private Collection <MasteryAbility> masteryAbilities;
	
	//Equipements
	//private Collection <Equipment> equipments;
	
	//Avantages
	//private Collection <Advantage> adventages;
	
	//Désavantages
	//private Collection <Disadvantage> disadvantages;
	
	//Flèches
	//private Map<Class, Long> arrows;
	
	//Arme principale
	//private Weapon primaryWeapon;
	
	//Armure
	//private Armor armor;
	
	//Points de blessures
	//private Wounds wounds;
	
	/**
	 * @return the agility
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getAgility() {
		return agility;
	}
	/**
	 * @param agility the agility to set
	 */
	public void setAgility(long agility) {
		this.agility = agility;
	}
	/**
	 * @return the airRing
	 */
	@Transient public long getAirRing() {
		return airRing;
	}
	/**
	 * @param airRing the airRing to set
	 */
	public void setAirRing(long airRing) {
		this.airRing = airRing;
	}
	/**
	 * @return the awareness
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getAwareness() {
		return awareness;
	}
	/**
	 * @param awareness the awareness to set
	 */
	public void setAwareness(long awareness) {
		this.awareness = awareness;
	}
	/**
	 * @return the clan
	 */
	public String getClan() {
		return clan;
	}
	/**
	 * @param clan the clan to set
	 */
	public void setClan(String clan) {
		this.clan = clan;
	}
	/**
	 * @return the earthRing
	 */
	@Transient public long getEarthRing() {
		return earthRing;
	}
	/**
	 * @return the fireRing
	 */
	@Transient public long getFireRing() {
		return fireRing;
	}
	/**
	 * @return the glory
	 */
	public long getGlory() {
		return glory;
	}
	/**
	 * @param glory the glory to set
	 */
	public void setGlory(long glory) {
		this.glory = glory;
	}
	/**
	 * @return the honor
	 */
	public long getHonor() {
		return honor;
	}
	/**
	 * @param honor the honor to set
	 */
	public void setHonor(long honor) {
		this.honor = honor;
	}
	/**
	 * @return the initiative
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getInitiative() {
		return initiative;
	}
	/**
	 * @param initiative the initiative to set
	 */
	public void setInitiative(long initiative) {
		this.initiative = initiative;
	}
	/**
	 * @return the insight
	 */
	@Transient public long getInsight() {
		return insight;
	}
	/**
	 * @param insight the insight to set
	 */
	public void setInsight(long insight) {
		this.insight = insight;
	}
	/**
	 * @return the intelligence
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getIntelligence() {
		return intelligence;
	}
	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(long intelligence) {
		this.intelligence = intelligence;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the perception
	 */
	public long getPerception() {
		return perception;
	}
	/**
	 * @param perception the perception to set
	 */
	public void setPerception(long perception) {
		this.perception = perception;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	/**
	 * @return the reflexes
	 */
	//@Range(min=1,max=10)	//CDC:2
	public long getReflexes() {
		return reflexes;
	}
	/**
	 * @param reflexes the reflexes to set
	 */
	public void setReflexes(long reflexes) {
		this.reflexes = reflexes;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * @return the shadowLandsTaint
	 */
	public long getShadowLandsTaint() {
		return shadowLandsTaint;
	}
	/**
	 * @param shadowLandsTaint the shadowLandsTaint to set
	 */
	public void setShadowLandsTaint(long shadowLandsTaint) {
		this.shadowLandsTaint = shadowLandsTaint;
	}
	/**
	 * @return the stamina
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getStamina() {
		return stamina;
	}
	/**
	 * @param stamina the stamina to set
	 */
	public void setStamina(long stamina) {
		this.stamina = stamina;
	}
	/**
	 * @return the status
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(long status) {
		this.status = status;
	}
	/**
	 * @return the strength
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getStrength() {
		return strength;
	}
	/**
	 * @param strength the strength to set
	 */
	public void setStrength(long strength) {
		this.strength = strength;
	}
	/**
	 * @return the tN
	 */
	public long getTN() {
		return TN;
	}
	/**
	 * @param tn the tN to set
	 */
	public void setTN(long tn) {
		TN = tn;
	}
	/**
	 * @return the voidRing
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getVoidRing() {
		return voidRing;
	}
	/**
	 * @param voidRing the voidRing to set
	 */
	public void setVoidRing(long voidRing) {
		this.voidRing = voidRing;
	}
	/**
	 * @return the voidRingPointsSpent
	 */
	public long getVoidRingPointsSpent() {
		return voidRingPointsSpent;
	}
	/**
	 * @param voidRingPointsSpent the voidRingPointsSpent to set
	 */
	public void setVoidRingPointsSpent(long voidRingPointsSpent) {
		this.voidRingPointsSpent = voidRingPointsSpent;
	}
	/**
	 * @return the waterRing
	 */
	@Transient public long getWaterRing() {
		return waterRing;
	}
	/**
	 * @return the willpower
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getWillpower() {
		return willpower;
	}
	/**
	 * @param willpower the willpower to set
	 */
	public void setWillpower(long willpower) {
		this.willpower = willpower;
	}
	/**
	 * @return the background
	 */
	public String getBackground() {
		return background;
	}
	/**
	 * @param background the background to set
	 */
	public void setBackground(String background) {
		this.background = background;
	}
	
	/**
	 * @see fr.lb.l5r.business.entities.Entity#getId()
	 */
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	/**
	 * @param id set the id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
