pragma solidity ^0.4.18;
contract DiamondContract {
  /*struct GHG {
    int carbon;
}*/

 struct Diamond {
    uint reportNumber;
    uint miles_travelled;
    int weight;
    int mine_location;
    int loc_1;
    int loc_2;
    int loc_3;
    int loc_4;
    int Footprint;
  }
  mapping (uint => Diamond) diamondList;
  function createDiamond(uint _id, uint _reportNumber
    ,uint _miles_travelled,
    int _weight,
    int _mine_location,
    int _loc_1,
    int _loc_2,
    int _loc_3,
    int _loc_4,
    int _footprint) public returns (bool) {
    diamondList[_id] = Diamond({
    reportNumber: _reportNumber,
    miles_travelled: _miles_travelled,
    weight: _weight,
    mine_location: _mine_location,
    loc_1: _loc_1,
    loc_2: _loc_2,
    loc_3: _loc_3,
    loc_4: _loc_4,
    Footprint: _footprint
    });
    return true;
  }
  function getGHGFootprint(uint _id) public constant returns (int) {
    int _carbon = diamondList[_id].Footprint;
    return (_carbon);
  }
  
 /*function getReport(uint _id) public constant returns (string, uint, string) {
    string storage _shapeStyle = diamondList[_id].shapeStyle;
    uint _caratWeight = diamondList[_id].caratWeight;
    string storage _cutGrade = diamondList[_id].cutGrade;
    return (_shapeStyle, _caratWeight, _cutGrade);
  }*/
}