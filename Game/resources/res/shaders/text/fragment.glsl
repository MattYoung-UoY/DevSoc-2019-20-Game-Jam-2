#version 400 core

in vec2 passTexCoords;

out vec4 out_Color;

uniform sampler2D textureSampler;

void main(void){

	vec4 textureColour = texture(textureSampler, passTexCoords);

	if(textureColour.a < 0.5) discard;

	out_Color = textureColour;

}