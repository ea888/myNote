namespace java thrift
namespace py tutorial

typedef i32 int // We can use typedef to get pretty names for the types we are using
service MultiplicationService
{
        int multiply(1:int n1, 2:int n2),
}

struct RestRequest  {
  1: optional i64 listingId (non_null)
}