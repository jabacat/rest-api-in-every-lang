require 'sinatra'

get '/' do
  'Hello world!'
end

get '/about' do
  'Very simple rest api using ruby. This is like zero boiler plate code, wow.'
end

get '/double/:number' do
  String(Integer(params['number']) * 2)
end

get '/half/:number' do
  String(Integer(params['number']) / 2)
end
