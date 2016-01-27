package com.yrdce.ipo.modules.sys;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ObservableBuilder {
	
    private Observable observable;
    
    private List<Observer> observers;
	
    
	public void init(){
		
    	if(observers!=null&&!observers.isEmpty()){
    		for(Observer observer:observers){
    			observable.addObserver(observer);
    		}
    	}
	}

	public Observable getObservable() {
		return observable;
	}


	public void setObservable(Observable observable) {
		this.observable = observable;
	}


	public List<Observer> getObservers() {
		return observers;
	}


	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}
	
    
	
	
	
}
