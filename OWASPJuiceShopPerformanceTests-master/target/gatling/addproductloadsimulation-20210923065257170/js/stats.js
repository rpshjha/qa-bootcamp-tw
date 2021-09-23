var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "3",
        "ok": "0",
        "ko": "3"
    },
    "minResponseTime": {
        "total": "700",
        "ok": "-",
        "ko": "700"
    },
    "maxResponseTime": {
        "total": "902",
        "ok": "-",
        "ko": "902"
    },
    "meanResponseTime": {
        "total": "832",
        "ok": "-",
        "ko": "832"
    },
    "standardDeviation": {
        "total": "93",
        "ok": "-",
        "ko": "93"
    },
    "percentiles1": {
        "total": "894",
        "ok": "-",
        "ko": "894"
    },
    "percentiles2": {
        "total": "898",
        "ok": "-",
        "ko": "898"
    },
    "percentiles3": {
        "total": "901",
        "ok": "-",
        "ko": "901"
    },
    "percentiles4": {
        "total": "902",
        "ok": "-",
        "ko": "902"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 3,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.188",
        "ok": "-",
        "ko": "0.188"
    }
},
contents: {
"req_login-user-35be0": {
        type: "REQUEST",
        name: "Login user",
path: "Login user",
pathFormatted: "req_login-user-35be0",
stats: {
    "name": "Login user",
    "numberOfRequests": {
        "total": "3",
        "ok": "0",
        "ko": "3"
    },
    "minResponseTime": {
        "total": "700",
        "ok": "-",
        "ko": "700"
    },
    "maxResponseTime": {
        "total": "902",
        "ok": "-",
        "ko": "902"
    },
    "meanResponseTime": {
        "total": "832",
        "ok": "-",
        "ko": "832"
    },
    "standardDeviation": {
        "total": "93",
        "ok": "-",
        "ko": "93"
    },
    "percentiles1": {
        "total": "894",
        "ok": "-",
        "ko": "894"
    },
    "percentiles2": {
        "total": "898",
        "ok": "-",
        "ko": "898"
    },
    "percentiles3": {
        "total": "901",
        "ok": "-",
        "ko": "901"
    },
    "percentiles4": {
        "total": "902",
        "ok": "-",
        "ko": "902"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 3,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.188",
        "ok": "-",
        "ko": "0.188"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
