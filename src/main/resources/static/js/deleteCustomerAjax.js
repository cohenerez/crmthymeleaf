$( document ).ready(function() {
  
  // SUBMIT FORM
    $("#customersForm").submit(function(event) {
    // Prevent the form from submitting via the browser.
    event.preventDefault();
   
    ajaxPost();
  });

  var customerId;
  var customerName;
  var status;

function ajaxPost(){
    
    getCustomerData();
    var url "./delete";
    status = "delete";
    
    var customer = {
            "customerId"    : customerId.value
            "customerName"  : customerName.value
            "status"        : status.value
    }
    
    $.ajax({
            type : "POST",
            contentType : 'application/json; charset=utf-8',
            dataType : 'json',
            url : url,
            data : JSON.stringify(customer),
            success : function(result) {
                console.log("SUCCESS: ", data);
                displayResulus(result);
                delBoxes();
            },
            error: function(e){
                console.log("ERROR: ", e);
                displayResulus(e);
            },
            done : function(e) {
                console.log("DONE");
            }
    });
 }


function delBoxes() {

    var boxes = document.getElementsByClassName('radioCheck');
        var tableTag;
        var rowTag;
        for (let i = 0; i < boxes.length; i++) {
            let box = boxes[i];
            if (box.checked) {
                rowTag = box.parentNode.parentNode;
                tableTag = box.parentNode.parentNode.parentNode;
                tableTag.removeChild(rowTag);
            }
        }
}

//---------------------------------------------------------------------

    function printData(){
            

            console.log(customer.customerId);
            console.log(customer.customerName);
      }


//-------------------------------------------------------------------------
    function getCustomerData() {
        //Reference the Table.
        var grid = document.getElementById("customersTable");

        //Reference the CheckBoxes in Table.
        var checkBoxes = grid.getElementsByTagName("INPUT");
      
              //Loop through the CheckBoxes.
        for (var i = 0; i < checkBoxes.length; i++) {
           
            if (checkBoxes[i].checked) {
                var row = checkBoxes[i].parentNode.parentNode;
                customerId = checkBoxes[i].value;
                customerName = row.cells[1].getElementsByTagName('a')[0].innerHTML;
                break;
            }
         }
       }
  
//---------------------------------------------------------------------------------


function displayResulus(data) {
    var json = "<h4>Eroare</h4><pre>"
            + JSON.stringify(data, null, 4) + "</pre>";
    $('#usernameError').html(json);
}


 })