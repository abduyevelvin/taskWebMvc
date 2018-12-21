var globalEmployeeId = 0;

$(function () {
    $('#employeeTableId').DataTable({
        'paging': true,
        'lengthChange': false,
        'searching': true,
        'ordering': true,
        'info': true,
        'autoWidth': true
    });

    $('#addEmployeeBtnId').click(function () {
        var cId = $('#cityCmbId').val();
        var eId = $('#experienceCmbId').val();
        if (cId != 0 && eId != 0) {
            addEmployee();
        }
        else {
            alert("Please choose a city...");
        }
    });

    $('#clearEmployeeBtnId').click(function () {
        clearEmployeeData();
    });

});

function clearEmployeeData() {
    $('#employeeNameId').val('');
    $('#employeeSurnameId').val('');
    $('#employeeAgeId').val(0);
    $('#employeeJobId').val('');
    $('#cityCmbId').val(0);
    $('#experienceCmbId').val(0);
}

function addEmployee() {
    var name = $('#employeeNameId').val();
    var surname = $('#employeeSurnameId').val();
    var age = $('#employeeAgeId').val();
    var job = $('#employeeJobId').val();
    var city = $('#cityCmbId').val();
    var experience = $('#experienceCmbId').val();

    var data = {
        name: name,
        surname: surname,
        age: age,
        job: job,
        city: city,
        experience: experience
    };

    $.ajax({
        url: 'addEmployee',
        type: 'POST',
        data: data,
        success: function (data) {
            if (data == "true") {
                alert("The Employee added successfully...");
                clearEmployeeData();
            }
            else {
                alert("Error! Employee cannot be addedd...");
            }
        }
    });
}

function updateEmployee() {
    var name = $('#employeeNameId').val();
    var surname = $('#employeeSurnameId').val();
    var age = $('#employeeAgeId').val();
    var job = $('#employeeJobId').val();
    var city = $('#cityCmbId').val();
    var experience = $('#experienceCmbId').val();

    var data = {
        name: name,
        surname: surname,
        age: age,
        job: job,
        city: city,
        experience: experience,
        empId: globalEmployeeId
    };

    $.ajax({
        url: 'updateEmployee',
        type: 'POST',
        data: data,
        success: function (data) {
            if (data == "true") {
                alert("The Employee edited successfully...");
                $('.employeeModalId').modal("hide");
                location.reload();
            }
            else {
                alert("Error! Employee cannot be edited...");
            }
        }
    });
}

function editEmployee(empId) {
    globalEmployeeId= empId;
    $.ajax({
        url: 'editEmployee',
        type: 'GET',
        data: 'empId=' + globalEmployeeId,
        dataType: 'html',
        success: function (data) {
            $('.modal-content').html(data);
            $('.employeeModalId').modal("show");
        }
    });
}

function viewEmployee(empId) {
    globalEmployeeId= empId;
    $.ajax({
        url: 'viewEmployee',
        type: 'GET',
        data: 'empId=' + globalEmployeeId,
        dataType: 'html',
        success: function (data) {
            $('.modal-content').html(data);
            $('.employeeModalId').modal("show");
        }
    });
}

function deleteEmployee(empId) {
    var yes = confirm("Are you sure to delete the employee?");
    if (yes) {
        $.ajax({
            url: 'deleteEmployee',
            type: 'POST',
            data: 'empId=' + empId,
            success: function (data) {
                if (data == "true") {
                    alert("The employee has been deleted successfully!");
                    location.reload();
                }
                else {
                    alert("Error, the employee is not deleted...");
                }
            }
        });
    }
}

function checkUser(username) {
    $.ajax({
        url: 'checkUser',
        type: 'GET',
        data: 'username=' + username,
        success: function (data) {
            if(data == "true") {
                alert("This username is already exist! Please, chose another username...");
            }
        }
    });
}