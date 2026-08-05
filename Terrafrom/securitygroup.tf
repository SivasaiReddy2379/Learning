provider "aws" {
  region = "us-east-1"
}
resource "aws_security_group" "mysg" {

  name = "TestSG"

  ingress {
    from_port   = 0
    to_port     = 0
    protocol    = -1
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port =22
    to_port =22
    protocol = "tcp"
    cidr_blocks =["0.0.0.0/0"]
  }
  egress {
    from_port  = 0
    to_port    = 0
    protocol   = -1
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "web" {
  tags = {
    Name        = "Dev"
    Environment = "Dev"
  }
  ami                    = "ami-0b6d9d3d33ba97d99"
  instance_type          = "t3.micro"
  vpc_security_group_ids = [aws_security_group.mysg.id]
  depends_on             = [aws_security_group.mysg]
}

----
