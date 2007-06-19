package fr.lb.l5r.business.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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
	private long stamina = 2;		//CDC:1
	private long willPower = 2;		//CDC:1

	//Anneaux d'eau	
	private long strength = 2; 		//CDC:1
	private long perception = 2;	//CDC:1

	//Anneaux de feu
	private long agility = 2;		//CDC:1
	private long intelligence = 2;	//CDC:1

	//Anneaux d'air	
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
	 * @return the airRing
	 */
	@Transient public long getAirRing() {
		return reflexes>awareness? awareness:reflexes; //CDC:3
	}
	///**
	// * @param airRing the airRing to set
	// */
	//public void setAirRing(long airRing) {
	//	this.airRing = airRing;
	//}
	/**
	 * @return the awareness
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getAwareness() {
		return awareness;
	}
	/**
	 * @return the clan
	 */
	public String getClan() {
		return clan;
	}
	/**
	 * @return the earthRing
	 */
	@Transient public long getEarthRing() {
		return stamina>willPower?willPower:stamina; //CDC:3
	}
	/**
	 * @return the fireRing
	 */
	@Transient public long getFireRing() {
		return agility>intelligence?intelligence:agility;
	}
	/**
	 * @return the glory
	 */
	public long getGlory() {
		return glory;
	}
	/**
	 * @return the honor
	 */
	public long getHonor() {
		return honor;
	}
	/**
	 * @return the initiative
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getInitiative() {
		return initiative;
	}
	/**
	 * @return the insight
	 */
	@Transient public long getInsight() {
		return insight;
	}
	/**
	 * @return the intelligence
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getIntelligence() {
		return intelligence;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the perception
	 */
	public long getPerception() {
		return perception;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @return the reflexes
	 */
	//@Range(min=1,max=10)	//CDC:2
	public long getReflexes() {
		return reflexes;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @return the shadowLandsTaint
	 */
	public long getShadowLandsTaint() {
		return shadowLandsTaint;
	}
	/**
	 * @return the stamina
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getStamina() {
		return stamina;
	}
	/**
	 * @return the status
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getStatus() {
		return status;
	}
	/**
	 * @return the strength
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getStrength() {
		return strength;
	}
	/**
	 * @return the tN
	 */
	public long getTN() {
		return TN;
	}
	/**
	 * @return the voidRing
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getVoidRing() {
		return voidRing;
	}
	/**
	 * @return the voidRingPointsSpent
	 */
	public long getVoidRingPointsSpent() {
		return voidRingPointsSpent;
	}
	/**
	 * @return the waterRing
	 */
	@Transient public long getWaterRing() {
		return strength>perception? perception:strength; //CDC:3
	}
	/**
	 * @return the willpower
	 */
	//@Range(min=1,max=10) //CDC:2
	public long getWillPower() {
		return willPower;
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
		Object oldValue = this.background;
		this.background = background;
		firePropertyChange("background", oldValue, this.background);
	}
	/**
	 * @param willPower the willPower to set
	 */
	public void setWillPower(long willPower) {
		Object oldEarthRing = this.getEarthRing();
		Object oldValue = this.willPower;
		this.willPower = willPower;
		firePropertyChange("willPower", oldValue, this.willPower);
		firePropertyChange("earthRing", oldEarthRing, this.getEarthRing());
	}
	/**
	 * @see fr.lb.l5r.business.entities.Entity#getId()
	 */
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	/**
	 * @param id set the id
	 */
	public void setId(int id) {
		Object oldValue = this.id;
		this.id = id;
		firePropertyChange("id", oldValue, this.id);
	}
	/**
	 * @param agility the agility to set
	 */
	public void setAgility(long agility) {
		Object oldFireRing = this.getFireRing();
		Object oldValue = this.agility;
		this.agility = agility;
		firePropertyChange("agility", oldValue, this.agility);
		firePropertyChange("fireRing", oldFireRing, this.getFireRing());
	}
	/**
	 * @param clan the clan to set
	 */
	public void setClan(String clan) {
		Object oldValue = this.clan;
		this.clan = clan;
		firePropertyChange("clan", oldValue, this.clan);
	}
	/**
	 * @param glory the glory to set
	 */
	public void setGlory(long glory) {
		Object oldValue = this.glory;
		this.glory = glory;
		firePropertyChange("glory", oldValue, this.glory);
	}
	/**
	 * @param honor the honor to set
	 */
	public void setHonor(long honor) {
		Object oldValue = this.honor;
		this.honor = honor;
		firePropertyChange("honor", oldValue, this.honor);
	}
	/**
	 * @param initiative the initiative to set
	 */
	public void setInitiative(long initiative) {
		Object oldValue = this.initiative;
		this.initiative = initiative;
		firePropertyChange("initiative", oldValue, this.initiative);
	}
	/**
	 * @param insight the insight to set
	 */
	public void setInsight(long insight) {
		Object oldValue = this.insight;
		this.insight = insight;
		firePropertyChange("insight", oldValue, this.insight);
	}
	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(long intelligence) {
		Object oldFireRing = this.getFireRing();
		Object oldValue = this.intelligence;
		this.intelligence = intelligence;
		firePropertyChange("intelligence", oldValue, this.intelligence);
		firePropertyChange("fireRing", oldFireRing,  this.getFireRing());
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Object oldValue = this.name;
		this.name = name;
		firePropertyChange("name", oldValue, this.name);
	}
	/**
	 * @param perception the perception to set
	 */
	public void setPerception(long perception) {
		Object oldWaterRing = this.getWaterRing();
		Object oldValue = this.perception;
		this.perception = perception;
		firePropertyChange("perception", oldValue, this.perception);
		firePropertyChange("waterRing", oldWaterRing,  this.getWaterRing());
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		Object oldValue = this.rank;
		this.rank = rank;
		firePropertyChange("rank", oldValue, this.rank);
	}
	/**
	 * @param reflexes the reflexes to set
	 */
	public void setReflexes(long reflexes) {
		Object oldAirRing = this.getAirRing();
		Object oldValue = this.reflexes;
		this.reflexes = reflexes;
		firePropertyChange("reflexes", oldValue, this.reflexes);
		firePropertyChange("airRing", oldAirRing,  this.getAirRing());
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		Object oldValue = this.school;
		this.school = school;
		firePropertyChange("school", oldValue, this.school);
	}
	/**
	 * @param shadowLandsTaint the shadowLandsTaint to set
	 */
	public void setShadowLandsTaint(long shadowLandsTaint) {
		Object oldValue = this.shadowLandsTaint;
		this.shadowLandsTaint = shadowLandsTaint;
		firePropertyChange("shadowLandsTaint", oldValue, this.shadowLandsTaint);
	}
	/**
	 * @param stamina the stamina to set
	 */
	public void setStamina(long stamina) {
		Object oldEarthRing = this.getEarthRing();
		Object oldValue = this.stamina;
		this.stamina = stamina;
		firePropertyChange("stamina", oldValue, this.stamina);
		firePropertyChange("earthRing", oldEarthRing,  this.getEarthRing());
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(long status) {
		Object oldValue = this.status;
		this.status = status;
		firePropertyChange("status", oldValue, this.status);
	}
	/**
	 * @param strength the strength to set
	 */
	public void setStrength(long strength) {
		Object oldWaterRing = this.getWaterRing();
		Object oldValue = this.strength;
		this.strength = strength;
		firePropertyChange("strength", oldValue, this.strength);
		firePropertyChange("waterRing", oldWaterRing, this.getWaterRing());
	}
	/**
	 * @param tn the tN to set
	 */
	public void setTN(long tn) {
		Object oldValue = TN;
		TN = tn;
		firePropertyChange("tn", oldValue, TN);
	}
	/**
	 * @param voidRing the voidRing to set
	 */
	public void setVoidRing(long voidRing) {
		Object oldValue = this.voidRing;
		this.voidRing = voidRing;
		firePropertyChange("voidRing", oldValue, this.voidRing);
	}
	/**
	 * @param voidRingPointsSpent the voidRingPointsSpent to set
	 */
	public void setVoidRingPointsSpent(long voidRingPointsSpent) {
		Object oldValue = this.voidRingPointsSpent;
		this.voidRingPointsSpent = voidRingPointsSpent;
		firePropertyChange("voidRingPointsSpent", oldValue, this.voidRingPointsSpent);
	}
	/**
	 * @param awareness the awareness to set
	 */
	public void setAwareness(long awareness) {
		Object oldAirRing = this.getAirRing();
		Object oldValue = this.awareness;
		this.awareness = awareness;
		firePropertyChange("awareness", oldValue, this.awareness);
		firePropertyChange("airRing", oldAirRing,  this.getAirRing());
	}
}
