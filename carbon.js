
	var Power_Coal=1001;
	var Power_Wind= 12;
	var Power_Solar= 46;
	var Power_Hydroelectric= 4;
	var Power_Nuclear= 16;
	

//var mySize = Sizeenum.SMALL;

var percentage_coal, percentage_hydro, percentage_solar, percentage_nuclear, percentage_Wind, Effective_Weight;
var alpha = 0.5;
var running_time_cut;
var running_time_polish;
var cut_machine_power;
var polish_machine_power;

// global struct of the type present on the chian
var _diamond = {
	'miles_travelled':1,
	'weight':1,
	'mine_Location':"diavik",
	'loc_1':12,
	'loc_2':43,
	'loc_3':6,
	'loc_4':36
};
var _car = {'miles_travelled':11,
	'type':111};

////fetch the struct and put it into the global

function transport_footprint(){
	//_diamond.miles_travelled = https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=pune&destinations=delhi&key=AIzaSyAqmDfljaMZMOlm4Uwk_CGv1T2UUs26oiw
	//Distance calculation through API
	//Add a loop here to calculate final miles from loc 1 to 2 to 3.....
	return (_diamond.weight * 5 * _diamond.miles_travelled * 0.0016)/1000;		//multiply by 5 to convert carat to gram.
}

function CutAndPolish()
{
	running_time_cut = 60 * 8;	//8 mins to cut
	running_time_polish = 60 * 8;	//8 mins to polish
	cut_machine_power = 3000;
	polish_machine_power = 6000;
	var kwh = (running_time_cut * cut_machine_power + running_time_polish * polish_machine_power)/3600000;
	return 1.1*kwh; //around 1 kg co2 produced for 1 kwh if produced through coal
}
	

function Set_Effective_Weight()	//the cost increases exponentially if weight is more than 1 carat, also if diamond is rare.
{
	var alpha = 1.1;
	if(_diamond.weight<=1)
	{
        Effective_Weight = _diamond.weight;
		return;
	}
	Effective_Weight = alpha * Math.exp(_diamond.weight);
	return;
}

function Carbon_footprint_mining(){
	if(_diamond.mine_Location == 'diavik')
	{
		
        percentage_coal =	0.0 ;
		percentage_hydro = 0.2;
		percentage_nuclear = 0.4;
		percentage_Wind = 0.3;
		percentage_solar = 0.1;
        return (Effective_Weight*66.3*((percentage_coal*Power_Coal)+(percentage_hydro*Power_Hydroelectric)+(percentage_nuclear*Power_Nuclear)+(percentage_Wind*Power_Wind)
		+(percentage_solar*Power_Solar)));
	}

	else if(_diamond.mine_Location == 'Argyle')
	{
		percentage_coal = 0.2;
		percentage_hydro = 0.2;
		percentage_nuclear = 0.3;
		percentage_Wind = 0.1;
		percentage_solar = 0.2;
		return Effective_Weight*7.5*((percentage_coal*Power_Coal)+(percentage_hydro*Power_Hydroelectric)+(percentage_nuclear*Power_Nuclear)+(percentage_Wind*Power_Wind)
		+(percentage_solar*Power_Solar));
	}

	else if(_diamond.mine_Location == 'Apollo')
	{
		percentage_coal = 0.2;
		percentage_hydro = 0.2;
		percentage_nuclear = 0.3;
		percentage_Wind = 0.1;
		percentage_solar = 0.2;

        return Effective_Weight*28*((percentage_coal*Power_Coal)+(percentage_hydro*Power_Hydroelectric)+(percentage_nuclear*Power_Nuclear)+(percentage_Wind*Power_Wind)
		+(percentage_solar*Power_Solar));
	}

	else if(_diamond.mine_Location == 'Namibia_Coast')
	{
		percentage_coal = 0.6;
		percentage_hydro = 0.2;
		percentage_nuclear = 0.0;
		percentage_Wind = 0.1;
		percentage_solar = 0.1;
		return Effective_Weight*80.3*((percentage_coal*Power_Coal)+(percentage_hydro*Power_Hydroelectric)+(percentage_nuclear*Power_Nuclear)+(percentage_Wind*Power_Wind)
		+(percentage_solar*Power_Solar));
	}

	else if(_diamond.mine_Location == 'synthetic_HPHT_GEMESIS')
	{
		percentage_coal = 0.2;
		percentage_hydro = 0.2;
		percentage_nuclear = 0.3;
		percentage_Wind = 0.1;
		percentage_solar = 0.2;
		return Effective_Weight*20*((percentage_coal*Power_Coal)+(percentage_hydro*Power_Hydroelectric)+(percentage_nuclear*Power_Nuclear)+(percentage_Wind*Power_Wind)
		+(percentage_solar*Power_Solar));
	}

	else if(_diamond.mine_Location == 'Ekati')
	{
		percentage_coal = 0.0;
		percentage_hydro = 0.2;
		percentage_nuclear = 0.4;
		percentage_Wind = 0.3;
		percentage_solar = 0.1;
		return Effective_Weight*21*((percentage_coal*Power_Coal)+(percentage_hydro*Power_Hydroelectric)+(percentage_nuclear*Power_Nuclear)+(percentage_Wind*Power_Wind)
		+(percentage_solar*Power_Solar));
	}
}
//Append new locations here
//transport is passes
function GetFootPrint()
{
Set_Effective_Weight();
console.log(transport_footprint());
   console.log(CutAndPolish());
console.log(Carbon_footprint_mining());

      // return (transport_footprint() + CutAndPolish() + Carbon_footprint_mining());
return 5;
}